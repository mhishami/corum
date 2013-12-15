# corum

This is a work in progress where I would pick and choose all the Clojure components that I'm going to work with to
complete a forum application in pure Clojure

Components use:
* Selmer https://github.com/yogthos/Selmer
* Compojure https://github.com/weavejester/compojure
* Lib-Noir https://github.com/noir-clojure/lib-noir
* Korma https://github.com/korma/Korma
* Timbre https://github.com/ptaoussanis/timbre
* Lobos http://budu.github.io/lobos/index.html
* PostgreSQL
* Log4j

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

```
lein ring server
```

## License

Copyright © 2013 Hisham Ismail
