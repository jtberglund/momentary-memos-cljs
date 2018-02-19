(ns momentary-memos-cljs.text-input)

(defn text-input [{:keys [value label on-change]}]
  [:div
   [:label {:htmlFor label} label]
   [:input {:type "text" :value value :on-change on-change}]])
