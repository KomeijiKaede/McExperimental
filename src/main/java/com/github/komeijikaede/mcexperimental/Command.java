package com.github.komeijikaede.mcexperimental;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class Command extends CommandBase{

	@Override
	public String getCommandName() {
		return "null";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
		SampleBlockCore.blockSample.setStart(0);
	}

}
