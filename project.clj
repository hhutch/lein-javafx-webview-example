(defproject lein-javafx-webview-example "0.1.0-SNAPSHOT"
  :description "JavaFx Webview Example"
  :url "http://stackoverflow.com/a/23228558/495999"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; :dependencies [[]]
  :java-source-paths ["src/"]
  :javac-options ["-target" "1.8" "-source" "1.8"]
  :main lein_javafx_webview_example.WebViewLocalHtml
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
)
