# GitHub User Activity CLI

A command-line tool that fetches and displays the recent activity of any GitHub user using the GitHub public API.

## Features

- Fetch recent GitHub activity for any public user
- Display activity with event type, repository, and timestamp
- Support for multiple event types (Push, Pull Request, Issues, Comments, etc.)
- Error handling for invalid usernames and API failures
- No external dependencies—uses Java's built-in HTTP client

## Getting Started

### Prerequisites

- Java 11 or higher
- Internet connection

### Compile

```bash
javac *.java
```

### Run

```bash
java Main <github-username>
```

### Example

```bash
java Main sahil-o-dev
```

### Example Output

```bash
$ java Main Sahil-O-Dev
Sahil-O-Dev made a push to Sahil-O-Dev/user-activity-cli at 2026-06-26T03:50:40Z
Sahil-O-Dev made a push to Sahil-O-Dev/user-activity-cli at 2026-06-25T20:15:38Z
Sahil-O-Dev made a push to Sahil-O-Dev/task-tracker at 2026-06-25T18:58:10Z
```

## How It Works

1. Takes a GitHub username as a command-line argument
2. Fetches the user's recent events from the GitHub API (`/users/<username>/events`)
3. Parses the JSON response without external libraries
4. Formats and displays each event with relevant details
5. Handles errors gracefully (invalid users, API failures, missing fields)

## Project

This is a solution for the [GitHub User Activity](https://roadmap.sh/projects/github-user-activity) project.