package plugin

import java.io.File
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration

object Config {
    private lateinit var config: FileConfiguration
    private lateinit var file: File

    fun load() {
        file = File(`RandomDropsOG`.plugin.dataFolder, "config.yml")
        if (!file.exists()) {
            `RandomDropsOG`.plugin.saveDefaultConfig()
        }

        config = YamlConfiguration.loadConfiguration(file)

        save()
    }

    private fun save() {
        config.save(file)
    }

    fun getSpawnerDropChance(): Double {
        return config.get("spawnerDropChance") as Double
    }

    fun getDragonEggDropChance(): Double {
        return config.get("dragonEggDropChance") as Double
    }
}
