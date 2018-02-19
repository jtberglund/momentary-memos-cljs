(ns momentary-memos-cljs.home
  (:require [reagent.core :as r]
            [momentary-memos-cljs.memo :refer [memo]]))

(defn home []
  (let [memos (r/atom [])]

    (fn []
      [:div {:class "container"}
       [memo {:title "test" :text "body"}]
       (if (empty? @memos)
         [:p "No memos yet. Click the button below to create one!"]
         [:div "memo-list"
          [:p (map (fn [] [memo {:title "m" :text "body"}]) memos)]])])))
