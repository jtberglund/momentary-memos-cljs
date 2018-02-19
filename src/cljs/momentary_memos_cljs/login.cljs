(ns momentary-memos-cljs.login
  (:require
   [reagent.core :as r]
   [momentary-memos-cljs.button :refer [button]]
   [momentary-memos-cljs.text-input :refer [text-input]]))

(defn login [{:keys [on-submit]}]
  (let [first-name (r/atom nil)
        last-name (r/atom nil)]

    (fn [{:keys [on-submit]}]
      [:div {:class "container"}
       [:h3 "Login"]
       [:form {:on-submit #(.preventDefault %)}
        [:field-set
         [text-input {:label "First Name"
                      :value @first-name
                      :on-change #(reset! first-name (-> % .-target .-value))}]
         [text-input {:label "Last Name"
                      :value @last-name
                      :on-change #(reset! last-name (-> % .-target .-value))}]
         [button {:text "Submit"
                  :on-click #(on-submit {:first-name @first-name :last-name @last-name})}]]]])))
