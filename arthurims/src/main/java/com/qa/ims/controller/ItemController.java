package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
			this.itemService = itemService;
		}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all item to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter an item name");
		String item_name = getInput();
		LOGGER.info("Please enter an item cost");
		String item_cost = getInput();
		Item item = itemService.create(new Item(item_name, item_cost));
		LOGGER.info("Order created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		int item_id = Integer.parseInt(getInput());
		LOGGER.info("Please enter an item name");
		String item_name = getInput();
		LOGGER.info("Please enter an item cost");
		String item_cost = getInput();
		Item item = itemService.update(new Item(item_id, item_name, item_cost));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the item
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		int item_id = Integer.parseInt(getInput());
		itemService.delete(item_id);
	}
}
