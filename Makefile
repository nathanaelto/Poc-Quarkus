.PHONY: dev docker-dev build docker-down

dev:
	@echo "Starting development server..."
	@./gradlew quarkusDev

docker-dev:
	@echo "Starting development container..."
	@docker-compose up -d

build:
	@echo "Building application..."
	@./gradlew build

docker-down:
	@echo "Stopping development container..."
	@docker-compose down

