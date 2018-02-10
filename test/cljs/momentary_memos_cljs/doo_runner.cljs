(ns momentary-memos-cljs.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [momentary-memos-cljs.core-test]))

(doo-tests 'momentary-memos-cljs.core-test)
