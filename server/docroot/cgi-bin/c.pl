##########################################################################
##
##  CGI Testing Example
##
##  Copyright (C) 1997-2000 RIT Research Labs
##
##########################################################################

print "Content-Type: text/html\n\n";

$args = $ENV{'QUERY_STRING'};

system("java -cp ..\\..\\..\\tinyweb-clojure\\resources\\clojure-1.10.0.jar;..\\..\\..\\tinyweb-clojure\\resources\\spec.alpha-0.2.176.jar;..\\..\\..\\tinyweb-clojure\\resources\\core.specs.alpha-0.2.44.jar;..\\..\\..\\tinyweb-clojure\\resources\\nrepl-0.6.0.jar;..\\..\\..\\tinyweb-clojure\\resources\\clojure-complete-0.2.5.jar;..\\..\\..\\tinyweb-clojure\\target\\tinyweb-clojure-1.0-SNAPSHOT.jar tinyweb.hello $args");

