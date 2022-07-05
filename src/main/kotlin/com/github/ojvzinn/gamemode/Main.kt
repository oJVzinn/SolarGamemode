package com.github.ojvzinn.gamemode

import com.github.ojvzinn.gamemode.cmd.Commands
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {

    companion object {
        private var instance: Main? = null

        fun getInstance(): Main? {
            return instance
        }
    }

    override fun onEnable() {
        instance = this

        Commands.setupCommands()

        Bukkit.getConsoleSender().sendMessage("§a[SolarGamemode] O plugin foi iniciado com sucesso!")
    }
}