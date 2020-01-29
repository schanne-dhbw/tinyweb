##########################################################################
##
##  CGI Testing Example
##
##  Copyright (C) 1997-2000 RIT Research Labs
##
##########################################################################

print "Content-Type: text/html\n\n";

print "<ul>\n";
$queryString = $ENV{'QUERY_STRING'};
print "<li>$queryString</li>\n";
print "</ul>\n";


