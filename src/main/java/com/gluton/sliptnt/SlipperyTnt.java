package com.gluton.sliptnt;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Material;
import net.minecraft.block.piston.PistonBehavior;

/**
 * @author Gluton
 */
public class SlipperyTnt implements ModInitializer {
	
	public static final Logger LOGGER = LogManager.getLogger();;
	
	@Override
	public void onInitialize() {
		try {
			Field tntField = Material.class.getDeclaredField("field_15960");
			tntField.setAccessible(true);
			
			Field modifiersField = null;
			Method getDeclaredFields0 = Class.class.getDeclaredMethod("getDeclaredFields0", boolean.class);
			getDeclaredFields0.setAccessible(true);
			Field[] fields = (Field[]) getDeclaredFields0.invoke(Field.class, false);
			for (Field field : fields) {
				if (field.getName().equals("modifiers")) {
					modifiersField = field;
					break;
				}
			}
			
			if (modifiersField != null) {
				modifiersField.setAccessible(true);
				modifiersField.setInt(tntField, tntField.getModifiers() & ~Modifier.FINAL);
				
				tntField.set(Material.TNT, PistonBehavior.PUSH_ONLY);
			} else {
				LOGGER.info("Unable to modify TNT pistonBehavior");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
