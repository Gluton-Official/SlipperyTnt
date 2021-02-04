package com.gluton.tntdr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

/**
 * @author Gluton
 */
public class TntDuperRemover implements ModInitializer {
	
	public static final Logger LOGGER = LogManager.getLogger();;
	
	@Override
	public void onInitialize() {
		LOGGER.info("Initialized TntDuperRemover");
	}
}
