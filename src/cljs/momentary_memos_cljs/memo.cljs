(ns momentary-memos-cljs.memo)

(defn memo [{:keys [title text]}]
  [:div {:class "memo"}
   [:span title]
   [:p text]])
