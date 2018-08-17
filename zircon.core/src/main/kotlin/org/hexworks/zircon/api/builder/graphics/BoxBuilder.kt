package org.hexworks.zircon.api.builder.graphics

import org.hexworks.zircon.api.builder.Builder
import org.hexworks.zircon.api.data.Size
import org.hexworks.zircon.api.data.Tile
import org.hexworks.zircon.api.graphics.Box
import org.hexworks.zircon.api.graphics.BoxType
import org.hexworks.zircon.api.graphics.StyleSet
import org.hexworks.zircon.api.resource.TilesetResource
import org.hexworks.zircon.api.util.Maybe
import org.hexworks.zircon.internal.config.RuntimeConfig
import org.hexworks.zircon.internal.graphics.DefaultBox

data class BoxBuilder(
        private var tileset: TilesetResource = RuntimeConfig.config.defaultTileset,
        private var size: Size = Size.create(3, 3),
        private var style: StyleSet = StyleSet.defaultStyle(),
        private var boxType: BoxType = BoxType.BASIC) : Builder<Box> {

    /**
     * Sets the size for the new [org.hexworks.zircon.api.graphics.Box].
     * Default is 3x3.
     */
    fun size(size: Size) = also {
        this.size = size
    }

    /**
     * Sets the style for the resulting [org.hexworks.zircon.api.graphics.Box].
     */
    fun style(style: StyleSet) = also {
        this.style = style
    }

    /**
     * Sets the [BoxType] for the resulting [org.hexworks.zircon.api.graphics.Box].
     */
    fun boxType(boxType: BoxType) = also {
        this.boxType = boxType
    }

    fun tileset(tileset: TilesetResource) = also {
        this.tileset = tileset
    }

    override fun build(): Box = DefaultBox(
            size = size,
            styleSet = style,
            boxType = boxType,
            tileset = tileset)

    override fun createCopy() = copy()

    companion object {

        /**
         * Creates a new [BoxBuilder] to build [org.hexworks.zircon.api.graphics.Box]es.
         */
        fun newBuilder() = BoxBuilder()

    }
}