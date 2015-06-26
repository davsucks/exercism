(require 'clojure.core)
(require 'clojure.string)
(clojure.core/in-ns 'bob)
(clojure.core/defn response-for 
    [input] 
    (clojure.core/cond
      (clojure.string/blank? input) "Fine. Be that way!"
      (clojure.core/not (clojure.string/blank? (clojure.core/re-matches (clojure.core/re-pattern "^[^a-z]*") input))) "Whoa, chill out!"
      (clojure.core/= (clojure.core/str (clojure.core/last input)) "?") "Sure."
      :else "Whatever.")
    )