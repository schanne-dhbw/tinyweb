(defproject tinyweb-clojure "1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [tinyweb-java/tinyweb-java "1.0-SNAPSHOT"]]
  :resource-paths ["resources" "../tinyweb-java/target/classes"]
  :source-path "src"
  :main ^:aot tinyweb.hello
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})