(defproject corum "0.1.0"
  :description "A Forum Application in Clojure"
  :url "http://github.com/mhishami/corum"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [lib-noir "0.7.7"]
                 [lobos "0.8.0"]
                 [korma "0.3.0-RC6"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [com.taoensso/timbre "3.0.0-RC2"]
                 [selmer "0.5.4"]
                 [log4j "1.2.15" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler corum.handler/app}
  :profiles
    {:dev
      {:dependencies [[javax.servlet/servlet-api "2.5"]
                      [ring-mock "0.1.5"]
                      [org.clojure/java.jdbc "0.2.3"]]}})
