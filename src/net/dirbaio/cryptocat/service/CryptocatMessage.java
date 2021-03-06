package net.dirbaio.cryptocat.service;

public class CryptocatMessage
{
	public final Type type;
	public final String nickname;
	public final String text;

    //Used for collapsing bubbles when rendering.
    public int left, right = -1;
    public int screenWidth = -1;
    public boolean firstInGroup = false;
    public boolean lastInGroup = false;

	public CryptocatMessage(String nickname, Type type)
	{
		this.nickname = nickname;
		this.type = type;
		this.text = null;
	}

	public CryptocatMessage(Type type, String nickname, String text)
	{
		this.type = type;
		this.nickname = nickname;
		this.text = text;
	}

	public enum Type
	{
		Message,
        MessageMine,
		Join,
		Leave,
        File,
        Error
	}

    @Override
    public String toString() {
        switch (type)
        {
            case Message:
            case MessageMine:
                return nickname+": "+text;
            case Join:
                return nickname+" joined";
            case Leave:
                return nickname+" left";
            case File:
                return nickname+" sent a file";
            case Error:
                return "Error: "+text;
            default:
                return "";
        }
    }
}
