(ns ^:figwheel-no-load momentary-memos-cljs.dev
  (:require
    [momentary-memos-cljs.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
