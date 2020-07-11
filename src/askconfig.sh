#!/usr/bin/env bash

MYSELF=$(which "$0" 2>/dev/null)
[ $? -gt 0 ] && [ -f "$0" ] && MYSELF="./$0"
java=java
if test -n "$JAVA_HOME"; then
    java="$JAVA_HOME/bin/java"
fi
exec "$java" -jar "$MYSELF" "$@"
exit 1
