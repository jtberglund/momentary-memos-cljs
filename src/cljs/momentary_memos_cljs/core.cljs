(ns momentary-memos-cljs.core
  (:require [reagent.core :as r :refer [atom]]
            [secretary.core :as secretary :include-macros true]
            [accountant.core :as accountant]
            [momentary-memos-cljs.login :as loginPage :refer [login]]
            [momentary-memos-cljs.navbar :refer [navbar]]
            [momentary-memos-cljs.home :refer [home]]))

;; -------------------------
;; Views

(defn home-page []
  [home])

(defn about-page []
  [:div [:h2 "About momentary-memos-cljs"]
   [:div [:a {:href "/"} "go to the home page"]]])

(defonce app-state (atom
                    {:first-name nil :last-name nil}))

(defn update-state! [key args]
  (swap! app-state #(assoc % key args)))

;; -------------------------
;; Routes

(defonce page (atom #'home-page))

(defn set-hash! [loc]
  (set! (.-location js/window) loc))

(defn login-page []
  [login {:on-submit (fn [{:keys [first-name last-name]}]
                       (reset! page #'home-page)
                       (update-state! :first-name first-name)
                       (update-state! :last-name last-name))}])

(defn app []
    ; (if (and (nil? @first-name) (not(= @page #'login)))
    ;   (set-hash! "/login")))

  [:div
   [navbar {:title "Momentary Memos" :first-name (@app-state :first-name)}]
   [@page]])

(secretary/defroute "/login" []
                    (reset! page #'login-page))

(secretary/defroute "/home" []
                    (reset! page #'home-page))
(secretary/defroute "/" []
                    (reset! page #'home-page))

(secretary/defroute "/about" []
                    (reset! page #'about-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [app] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (secretary/dispatch! path))
    :path-exists?
    (fn [path]
      (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
