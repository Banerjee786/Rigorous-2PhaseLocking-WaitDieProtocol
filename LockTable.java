
/*
Priyam Banerjee
The University of Texas at Arlington
Citation : 
http://www.mathcs.emory.edu/~cheung/Courses/554/Syllabus/8-recv+serial/deadlock-compare.html
https://cs.nyu.edu/courses/fall15/CSCI-GA.2433-001/slides/Unit12.pdf
*/

public class LockTable
{
	public int transid_WL;
	public int transid_RL;
	public int trans_waiting_read;
	public int trans_waiting_write;

	
	public LockTable()
	{		
		this.transid_WL = 0;
		this.transid_RL = 0;
		this.trans_waiting_read = 0;
		this.trans_waiting_write = 0;		
	}
	
	public int Get_transid_RL()
	{
		return this.transid_RL;
	}
	public int Get_transid_WL()
	{	
		return this.transid_WL;
	}
	public int Get_trans_waiting_read()
	{	
		return this.trans_waiting_read;
	}
	public int Get_trans_waiting_write()
	{	
		return this.trans_waiting_write;
	}

	
	public void Set_transid_WL(int x)
	{	
		this.transid_WL=x;
	}
	public void Set_trans_waiting_read(int x)
	{
		String y;
		y = Integer.toString(this.trans_waiting_read) + Integer.toString(x);
		this.trans_waiting_read = Integer.parseInt(y);
	}
	public void Set_transid_RL(int x)
	{	
		String y;
		y = Integer.toString(this.transid_RL) + Integer.toString(x);
		this.transid_RL = Integer.parseInt(y);
	}
	public void Set_trans_waiting_write(int x)
	{	
		String y;
		y = Integer.toString(this.trans_waiting_write) + Integer.toString(x);
		this.trans_waiting_write= Integer.parseInt(y);
	}

	
	public void release_transid_lock(int id)
	{
		if (id == this.Get_transid_RL())
			this.transid_RL = 0;
		if (id == this.Get_transid_WL())
			this.transid_WL = 0;
		if (id == this.Get_trans_waiting_read())
			this.trans_waiting_read = 0;
		if (id == this.Get_trans_waiting_write())
			this.trans_waiting_write = 0;
		if (this.Get_transid_RL() > 10)
		{
			StringBuilder sb = new StringBuilder(Integer.toString(this.Get_transid_RL()));
			int i = sb.indexOf(Integer.toString(id));
			if (i >= 0) {
				sb.deleteCharAt(i);
				this.transid_RL = Integer.parseInt(sb.toString());
			}
		}
		if (this.Get_transid_WL() > 10)
		{
			StringBuilder sb = new StringBuilder(Integer.toString(this.Get_transid_WL()));
			int i = sb.indexOf(Integer.toString(id));
			if (i >= 0)
			{
				sb.deleteCharAt(i);
				this.transid_WL = Integer.parseInt(sb.toString());
			}
		}
		if (this.Get_trans_waiting_read() > 10)
		{
			StringBuilder sb = new StringBuilder(Integer.toString(this.Get_trans_waiting_read()));
			int i = sb.indexOf(Integer.toString(id));
			if (i >= 0)
			{
				sb.deleteCharAt(i);
				this.trans_waiting_read = Integer.parseInt(sb.toString());
			}
		}
		if (this.Get_trans_waiting_write() > 10)
		{
			StringBuilder sb = new StringBuilder(Integer.toString(this.Get_trans_waiting_write()));
			int i = sb.indexOf(Integer.toString(id));
			if (i >= 0)
			{
				sb.deleteCharAt(i);
				this.trans_waiting_write = Integer.parseInt(sb.toString());
			}
		}
	}

		public void replace_transid_RL()
		{
			this.transid_RL = 0;
		}
		public void replace_transid_WL()
		{
			this.transid_WL = 0;
		}
		public void replace_transid_waiting_RL()
		{
			this.trans_waiting_read = 0;
		}
		public void replace_transid_waiting__WL()
		{
			this.trans_waiting_write= 0;
		}
}