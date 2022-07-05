package com.github.ojvzinn.gamemode.cmd

import com.github.ojvzinn.gamemode.Main
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import java.util.logging.Level

abstract class Commands(name: String?, vararg aliases: String?) : Command(name) {
    init {
        this.aliases = listOf(*aliases)
        try {
            val simpleCommandMap = Bukkit.getServer().javaClass.getDeclaredMethod("getCommandMap")
                .invoke(Bukkit.getServer()) as SimpleCommandMap
            simpleCommandMap.register(this.name, "solargamemode", this)
        } catch (ex: ReflectiveOperationException) {
            Main.getInstance()?.logger?.log(Level.SEVERE, "Cannot register command: ", ex)
        }
    }

    abstract fun perform(sender: CommandSender?, label: String?, args: Array<String>?)
    override fun execute(sender: CommandSender, commandLabel: String, args: Array<String>): Boolean {
        perform(sender, commandLabel, args)
        return true
    }

    companion object {
        fun setupCommands() {
            GmCommand()
        }
    }
}