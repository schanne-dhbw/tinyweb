##########################################################################
##
##  CGI Testing Example
##
##  Copyright (C) 1997-2000 RIT Research Labs
##
##########################################################################

print "Content-Type: text/html\n\n";

$args = $ENV{'QUERY_STRING'};

system("scala -cp ..\\..\\..\\tinyweb-scala\\target\\classes tinyweb.TinyWebViaPerl $args");

