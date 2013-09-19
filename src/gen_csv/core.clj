(ns gen-csv.core
  (require [clojure.string           :as string]
           [clojure.core.memoize     :as memo]
           [clojure.java.io          :as io]
           [clojure.data.csv         :as csv]
           [clojure.data.generators  :as gen]
           [clj-time.format          :as tf]
           [clojure.tools.reader.edn :as edn]
           [me.raynes.fs             :as fs]))

(def file-path
  (atom "example.edn"))

(defn raw
  "Read config string from config-file"
  [path]
  (string/trim (slurp (fs/normalized-path path))))

(def config
  (memo/memo #(edn/read-string (raw @file-path))))

(defn reset-file-path!
  ""
  [path]
  (do
    (reset! file-path path)
    (memo/memo-clear! config)))

(defn append!
  "Append a data vector to a file path"
  [file data]
  (with-open [wtr (io/writer file :append true)]
    (csv/write-csv wtr [data]
      :newline   :cr+lf
      :quote     \"
      :separator \tab)))

(defn data
  []
  (eval ((config) :data)))

(defn output-file
  []
  ((config) :output-file))

(defn lines
  []
  ((config) :lines))

(defn generate!
  []
  (time
    (do
      (println (str (lines) " rows will be written to " (output-file)))
      (loop [cnt 0]
        (if (>= cnt (lines))
          (println (str cnt " rows were written to " (output-file)))
          (do
            (append! (output-file) (data))
            (recur (inc cnt))))))))

(defn -main
  [config-file]
  (do
    (in-ns 'gen-csv.core)
    (reset-file-path! config-file)
    (generate!)))
