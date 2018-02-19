(ns momentary-memos-cljs.button)

(defn button [{:keys [text on-click]}]
  [:button {:on-click on-click} text])
