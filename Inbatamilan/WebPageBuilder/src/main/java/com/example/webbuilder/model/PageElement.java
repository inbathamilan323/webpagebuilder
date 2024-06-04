package com.example.webbuilder.model;

public class PageElement {
    private String id;
    private String type;
    private int width;
    private int height;
    private String color;
    private String font;
    private int fontSize;

    public PageElement() {
    }

    public PageElement(String id, String type, int width, int height, String color, String font, int fontSize) {
        this.id = id;
        this.type = type;
        this.width = width;
        this.height = height;
        this.color = color;
        this.font = font;
        this.fontSize = fontSize;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

    
}