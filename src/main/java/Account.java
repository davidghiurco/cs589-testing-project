//***********************************************
//************* CLASS ACCOUNT *******************
//***********************************************


public class Account
{
	private int x0; // CONST: maximum number of pin tries
	private int x1; // balance
	private int x2; // locked or not
	private int x3; // pin number
	private int x4; // state
	private int x5; // account number
	private int x6; // CONST: $20 fee for each transaction (withdraw, deposit) in overdrawn state
	private int x7; // CONST: minimum balance ($500)
	private int x8; // lock number
	private int x9; // number of pin tries

public final int show_locked_flag() {
    return x2;
} // testing oriented method

public final int show_num_pin_tries() {
    return x9;
} // testing oriented method

public final int show_balance()
{
	return x1;
} // testing oriented method

public final String show_state() { // testing oriented method
    if (x4 == -1) {
        return "INITIAL";
    }
    if (x4 == 0) {
        return "IDLE";
    }
    else if (x4 == 1) {
        return "CHECK PIN";
    }
    else if (x4 == 2 && x1 >= x7) {
        return "READY";
    }
    else if ((x4 == 2 && x1 < x7)) {
        return "OVERDRAWN";
    }
    else if (x4 == 2 && x2 == 1) {
        return "LOCKED";
    }
    return "ERROR: UNKNOWN";
}

public Account()
{
	x2 = 0;
	x4 = -1;
	x6 = 20;
	x7 = 500;
	x9 = 0;
	x0 = 3;
}
public final int open(int x, int y, int z)
{
	if ((x > 0) && (x4 == -1) && (y > 0) && (z > 0))
	{
		x1 = x;
		x3 = y;
		x5 = z;
		x4 = 0;
		return 0;
	};
	return -1;
}
public final int pin(int x)
{
	if (x4 != 1)
	{
		return -1;
	}
	if (x == x3)
	{
		x4 = 2;
		return 0;
	}
	else
	{
		x9++;
	}
	if (x9 >= x0)
	{
		x4 = 0;
	}
	return -1;
}
public final int logout()
{
	if ((x4 == 0) || (x2 == 1))
	{
		return -1;
	}
	x4 = 0;
	return 0;
}
public final int login(int x)
{
	if (x4 != 0)
	{
		return -1;
	}
	if (x5 == x)
	{
		x4 = 1;
		x9 = 0;
		return 0;
	}
	return -1;
}
public final int balance()
{
	if (x4 != 2)
	{
		return -1;
	}
	return x1;
}
public final int lock(int x)
{
	if (x4 != 2)
	{
		return -1;
	}
	if (x == x3)
	{
		return -1;
	}
	if (x2 == 0)
	{
		x2 = 1;
		x8 = x;
		return 0;
	}
	else
	{
		return -1;
	}
}
public final int unlock(int x)
{
	if (x4 != 2)
	{
		return -1;
	}
	if ((x2 == 1) && (x == x8))
	{
		x2 = 0;
	return 0;
	}
	else
	{
		return -1;
	}
}
public final int deposit(int d)
{
	if (x4 != 2)
	{
		return -1;
	}
	if (x2 == 1)
	{
		return -1;
	};
	if ((x1 + d < x7) && (d>0))
	{
		x1 = x1 + d - x6;
		return 0;
	}
	else
	{
		if (d > 0)
		{
		x1 = x1 + d;
		return 0;
		}
	}
 return -1;
}
public final int withdraw(int w)
{
if (x4 != 2)
{
	return -1;
}
if (x2 == 1)
{
	return -1;
};
if ((x1 > w) && (w > 0))
{
	if (x1 < x7)
	{
		return -1;
	}
	else
	{
		x1 = x1 - w;
	};
	if (x1 < x7)
	{
		x1 = x1 - x6;
	}
  return 0;
}
return -1;
}
}