# Minecraft Fabric Template
This template is designed to start a Minecraft Fabric modification.

It is based on [Corntopia](https://github.com/cloewen8/Corntopia) and shares
many of its features and documentation.

When starting a project with this template, check the following sections:
- README.md (this file)
  - Mod (name, badge and description)
  - Installation (name, GitHub links and mod-specific instructions)
  - Features (feature name, description, details and previews)
  - Contributing (GitHub links)
  - Pull requests (mod-specific requirements)
  - License (verify the license, copyright date and link to the LICENSE.md file)
- RELEASE.md
  - Verify the release process.
  - Choose platform specific release processes.
- LICENSE.md
  - Verify the copyright date.
- gradle.properties
  - Customize everything!
- src
  - Set package name.
- src/main/resources/fabric.mod.json
  - Customize everything!
- src/main/resources/mod.mixins.json
  - Rename mod.
  - Add mixins.
- src/main/java/ca/cjloewen/mod/Mod.java
  - Prefix with the mod name.
- src/main/java/ca/cjloewen/mod/item/Items.java
  - Add items.
- src/main/java/ca/cjloewen/mod/block/Blocks.java
  - Add blocks.
- .github/workflows/build.yml
  - Remove unused release tasks
  - For the "Create release" task, set the release_name.
  - For the "Attach release" task, set the asset_path and asset_name.
  - For the "Upload to CurseForge" task, set the CURSE_FORGE_API_TOKEN secret and set file_path and display_name.
- .github/ISSUE_TEMPLATE/bug_report.md
  - Add the mod name to Desktop.

# Mod
![build](https://github.com/cloewen8/**Mod**/workflows/build/badge.svg)

**A description of the mod!**

## Installation
**It** is designed using Fabric and can be installed like any other Fabric mod.

1. If you have not already, install Fabric:
   
   https://fabricmc.net/wiki/install
2. You will also need the Fabric API:
   
   https://www.curseforge.com/minecraft/mc-mods/fabric-api
3. **It** is provided through GitHub Releases:
   
   **https://github.com/cloewen8/Mod/releases**
   
   Try to pick a version that matches your Minecraft version. If a release for your version of Minecraft does not exist, try the newest release. If you experience any compatibility problems, please create a ticket:
   
   https://github.com/cloewen8/Mod/issues/new/choose

## Features (spoilers)
- **Feature** - Short description.
  - Detail.

![Alternative text](preview/feature.png)

## Contributing
__Contributions welcome!__

The best way you can contribute is by providing your unique perspective in [discussions](https://github.com/cloewen8/Mod/discussions) and [issues](https://github.com/cloewen8/Mod/issues). If you want to contribute more directly, consider creating a [pull request](https://github.com/cloewen8/Mod/compare).

- Be respectful and avoid destructive comments.
- Don't use offensive language, including swear words and hate speech.

### Issues
If you experience any problems using the mod, consider creating an issue. Examples include:

- If you suspect the mod caused Minecraft to crash.
- If a feature is not working as expected.
- If a feature is missing.

### Pull requests
A pull request allows you to directly make changes to the mod.

- Changes could include (but are not limited to): Adding new features, fixing bugs, adding translations, and tweaking textures.
- It is heavily recommended you open a discussion ahead of time discussing your changes. This helps me and the rest of the community to coordinate our efforts.
- Keep writing (code and documentation) consistent.
- You should test your changes and create test cases when possible. All tests must pass before the pull request is accepted. I will manually test all pull requests when possible.

## License
Copyright 2020 Colton Loewen

Licensed under the Apache License, Version 2.0. To summarize, this allows you to:

- Use the mod for personal use.
- Use the mod on your server.
- Add the mod to a mod-pack.
- Modify and redistribute your own version of the mod.

**As long as:**

- You provide the included license.
- You document any changes.

**This summary is not a substitute for the full license**, which is available in [LICENSE.md](https://github.com/cloewen8/Mod/blob/master/LICENSE.md).
