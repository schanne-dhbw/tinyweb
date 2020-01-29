##########################################################################
##
##  CGI Testing Example
##
##  Copyright (C) 1997-2000 RIT Research Labs
##
##########################################################################

print "Content-Type: text/html\n\n";

chdir('clojure_example') or die "$!";

$className = $ENV{'QUERY_STRING'};

system("java -cp resources\\clojure-1.10.0.jar;resources\\spec.alpha-0.2.176.jar;resources\\core.specs.alpha-0.2.44.jar;resources\\nrepl-0.6.0.jar;resources\\clojure-complete-0.2.5.jar;target\\clojure_example-0.1.0-SNAPSHOT.jar $className");

