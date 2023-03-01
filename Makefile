.PHONY: dev docker-dev build

dev:
	@echo "Starting development server..."
	@./gradlew quarkusDev

docker-dev:
	@echo "Starting development container..."
	@docker-compose up -d

build:
	@echo "Building application..."
	@./gradlew build