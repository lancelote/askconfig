#!/usr/bin/env bash

if ! MYSELF=$(which "$0" 2>/dev/null) && [ -f "$0" ]; then
  MYSELF="./$0"
fi

java=java

if test -n "$JAVA_HOME"; then
  java="$JAVA_HOME/bin/java"
fi

exec "$java" -jar "$MYSELF" "$@"
exit 1
