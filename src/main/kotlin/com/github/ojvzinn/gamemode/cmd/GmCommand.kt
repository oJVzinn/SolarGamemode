package com.github.ojvzinn.gamemode.cmd

import org.bukkit.GameMode
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GmCommand(): Commands("gamemode", "gm") {

    override fun perform(sender: CommandSender?, label: String?, args: Array<String>?) {
        if (sender !is Player) {
            sender?.sendMessage("Este comando é exclusivo para jogadores!")
            return
        }

        val player:Player = sender

        if (args?.isEmpty()!!) {
            player.sendMessage("§cUso incorreto! Tente /gm (0/1/2/3)")
            return
        }
        val gm = args[0]
        if (gm == "0") {
            player.sendMessage("§aGamemode alterado para survival!")
            player.gameMode = GameMode.SURVIVAL
        } else if (gm == "1") {
            player.sendMessage("§aGamemode alterado para creative!")
            player.gameMode =  GameMode.CREATIVE
        } else if (gm == "2") {
            player.sendMessage("§aGamemode alterado para adventure!")
            player.gameMode = GameMode.ADVENTURE
        } else if (gm == "3") {
            player.sendMessage("§aGamemode alterado para spectator!")
            player.gameMode = GameMode.SPECTATOR
        }
    }
}