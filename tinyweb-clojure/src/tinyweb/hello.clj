(ns tinyweb.hello
  (:gen-class)
  (:use [mbfpp.oo.tinyweb.example]))

(defn -main
  "Main entry point."
  [& args]
 ; (println "Hello, World!" (first args)))
  (def request {:path "/greeting" :body (first args)})
  (println (greeting-view (handle-greeting request))))
