/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package forestry.arboriculture.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import forestry.arboriculture.gadgets.TileFruitPod;
import forestry.arboriculture.gadgets.TileLeaves;
import forestry.core.network.PacketCoordinates;
import forestry.core.network.PacketId;

public class PacketRipeningUpdate extends PacketCoordinates {

	private int value;

	public PacketRipeningUpdate(DataInputStream data) throws IOException {
		super(data);
	}

	public PacketRipeningUpdate(TileFruitPod fruitPod) {
		super(PacketId.RIPENING_UPDATE, fruitPod);
		value = fruitPod.getMaturity();
	}

	public PacketRipeningUpdate(TileLeaves leaves) {
		super(PacketId.RIPENING_UPDATE, leaves);
		value = leaves.getFruitColour();
	}

	@Override
	public void writeData(DataOutputStream data) throws IOException {
		super.writeData(data);
		data.writeInt(value);
	}

	@Override
	public void readData(DataInputStream data) throws IOException {
		super.readData(data);
		value = data.readInt();
	}

	public int getValue() {
		return value;
	}
}
