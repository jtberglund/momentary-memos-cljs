(ns momentary-memos-cljs.middleware
  (:require [ring.middleware.defaults :refer [site-defaults wrap-defaults]]))

(defn wrap-middleware [handler]
  (wrap-defaults handler site-defaults))
