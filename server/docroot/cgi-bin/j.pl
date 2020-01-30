##########################################################################
##
##  CGI Testing Example
##
##  Copyright (C) 1997-2000 RIT Research Labs
##
##########################################################################

print "Content-Type: text/html\n\n";

$args = $ENV{'QUERY_STRING'};

system("java -cp ..\\..\\..\\tinyweb-java\\target\\tinyweb-java-1.0-SNAPSHOT.jar tinyweb.TinyWebViaPerl $args");

