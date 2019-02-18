package com.apps.app2

data class Usuario(val uid: String?, val username: String?, val platforms: List<String>?, val error: Boolean?)

data class DatosUsuario(val data: Device?) {

    // Partidas Solo Keyboard
    fun getVictoriasSoloKeyboard(): Int? {
        return data?.keyboardmouse?.defaultsolo?.default?.placetop1
    }

    fun getPartidasJugadasSoloKeyboard(): Int? {
        return data?.keyboardmouse?.defaultsolo?.default?.matchesplayed
    }

    fun getAsesinatosSoloKeyboard(): Int? {
        return data?.keyboardmouse?.defaultsolo?.default?.kills
    }

    // Partidas Duo Keyboard
    fun getVictoriasDuoKeyboard(): Int? {
        return data?.keyboardmouse?.defaultduo?.default?.placetop1
    }

    fun getPartidasJugadasDuoKeyboard(): Int? {
        return data?.keyboardmouse?.defaultduo?.default?.matchesplayed
    }

    fun getAsesinatosDuoKeyboard(): Int? {
        return data?.keyboardmouse?.defaultduo?.default?.kills
    }

    // Partidas Squad Keyboard
    fun getVictoriasSquadKeyboard(): Int? {
        return data?.keyboardmouse?.defaultsquad?.default?.placetop1
    }

    fun getPartidasJugadasSquadKeyboard(): Int? {
        return data?.keyboardmouse?.defaultsquad?.default?.matchesplayed
    }

    fun getAsesinatosSquadKeyboard(): Int? {
        return data?.keyboardmouse?.defaultsquad?.default?.kills
    }

    // Partidas Solo Gamepad
    fun getVictoriasSoloGamepad(): Int? {
        return data?.gamepad?.defaultsolo?.default?.placetop1
    }

    fun getPartidasJugadasSoloGamepad(): Int? {
        return data?.gamepad?.defaultsolo?.default?.matchesplayed
    }

    fun getAsesinatosSoloGamepad(): Int? {
        return data?.gamepad?.defaultsolo?.default?.kills
    }

    // Partidas Duo Gamepad
    fun getVictoriasDuoGamepad(): Int? {
        return data?.gamepad?.defaultduo?.default?.placetop1
    }

    fun getPartidasJugadasDuoGamepad(): Int? {
        return data?.gamepad?.defaultduo?.default?.matchesplayed
    }

    fun getAsesinatosDuoGamepad(): Int? {
        return data?.gamepad?.defaultduo?.default?.kills
    }

    // Partidas Squad Gamepad
    fun getVictoriasSquadGamepad(): Int? {
        return data?.gamepad?.defaultsquad?.default?.placetop1
    }

    fun getPartidasJugadasSquadGamepad(): Int? {
        return data?.gamepad?.defaultsquad?.default?.matchesplayed
    }

    fun getAsesinatosSquadGamepad(): Int? {
        return data?.gamepad?.defaultsquad?.default?.kills
    }
}

data class Device(val keyboardmouse: DefaultMode, val gamepad: DefaultMode)

data class DefaultMode(val defaultsolo: Default?, val defaultduo: Default?, val defaultsquad: Default?)

data class Default(val default: Data)

data class Data(val placetop1: Int?, val matchesplayed: Int?, val kills: Int?)