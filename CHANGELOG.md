# Changelog

All notable changes to this project will be documented in this file 
and the format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).  
Disclaimer; I'm not the best in keeping a log, so do not expect much.. I'm doing my best! 😊

## [1.1.0] - 2021-08-26
### Added
- Config file (JSON5) has been added with an array of the loot-table.  
  *This is an early version and still needs a lot of work.*

### Changed
- `GeodeTable.java` has been replaced by an improved version: `GeodeLootTable.java`.
- `GeodeTableEntry.java` has been replaced by `GeodeLootTableEntry.java` just for name sake.
- You're not getting the same item twice in a row anymore unless it is `minecraft:air`.

## [1.0.0] - 2021-08-25
### Added
- `Deepslate Geode` and `Stone Geode` with custom textures.
- Loot pools for `minecraft:stone` and `minecraft:deepslate` that makes geodes drop.
- `GeodeTable` that has at this moment hardcoded chances for material to drop from geodes.
- Particles and sounds upon 'breaking' geodes on a anvil.
- Translations: [ [English](src/main/resources/assets/geodes/lang/en_us.json) ].