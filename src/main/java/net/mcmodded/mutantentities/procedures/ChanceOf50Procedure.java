package net.mcmodded.mutantentities.procedures;

public class ChanceOf50Procedure {
	public static boolean execute() {
		return Math.random() < 0.5;
	}
}
