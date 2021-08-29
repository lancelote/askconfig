install:
	./gradlew clean
	./gradlew build
	cat src/askconfig.sh build/libs/disableSettingsImport-*.jar > askconfig
	chmod +x askconfig
	mkdir -p ~/.bin/
	mv askconfig ~/.bin/
