(ns momentary-memos-cljs.prod
  (:require [momentary-memos-cljs.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
