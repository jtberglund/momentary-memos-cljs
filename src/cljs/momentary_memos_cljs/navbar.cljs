(ns momentary-memos-cljs.navbar
  (:require [reagent.core :as r]))

(defn navbar [{:keys [title first-name]}]
  [:nav {:class "nav"}
   [:div {:class "container"}
    [:h1 title]
    [:div {:class "nav__welcome"}
     [:span (if (nil? first-name)
              "Welcome, please log in below"
              (str "Hello, " first-name))]]]])
