install:
	./gradlew clean
	./gradlew build
	cat src/askconfig.sh build/libs/disableSettingsImport-*.jar > askconfig
	chmod +x askconfig
	mkdir ~/.bin/ 2>/dev/null
	mv askconfig ~/.bin/
