# Void Client

A deobfuscated RuneScape 634 (2010-12-14) client.

## Requirements

- **Java Development Kit (JDK) 8**: The project is configured to use Java 8.
- **32-bit JRE**: Required for OpenGL and DirectX support.
- **Gradle**: (Optional) The project uses the included Gradle Wrapper (`gradlew`).

## Setup & Build

Build the client using the Gradle Wrapper:

```bash
./gradlew shadowJar
```

The executable "fat" JAR will be located at:
`client/build/libs/void-client.jar`

### Bundling with JRE
You can create a bundle that includes a 32-bit JRE (configured in `client/build.gradle.kts` via `jrePath`):

```bash
./gradlew bundleApp
```
The output will be in `client/build/dist/void-bundle.zip`.

## Running the Client

To run the client from the built JAR:

```bash
java -jar client/build/libs/void-client.jar
```

If you encounter issues with OpenGL or DirectX, ensure you are using a 32-bit JRE:

```bash
# Example force 32-bit if supported by your JVM
java -d32 -jar client/build/libs/void-client.jar
```

### Command Line Arguments
- `-ip`, `--address <IP>`: Connect to a specific server address (default: `127.0.0.1`).
- `-p`, `--port <Port>`: Connect to a specific port (default: `43594`).
- `-d`, `--debug`: Enable debug mode.
- `-t`, `--trace`: Enable trace logging.

## Project Structure

- `client/src`: Source code for the client.
- `client/resources`: Client assets (icons, etc.).
- `libs`: External dependencies (including `clientlibs.jar`).
- `gradle`: Gradle Wrapper configuration.

## Scripts & Tasks

- `./gradlew shadowJar`: Builds the executable fat JAR.
- `./gradlew bundleApp`: Bundles the client with a local 32-bit JRE.

## License

This project is licensed under the [LICENSE](LICENSE) file.
