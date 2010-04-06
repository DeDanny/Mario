/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.state;

import mario.Mario;


/**
 *
 * @author Onno
 */
public class BigMario extends MoveState
{
    protected static String[] RightAnimation =
    {
        "bigMarioWalkRight 0", "bigMarioWalkRight 1"
    };
    protected  static String[] LeftAnimation =
    {
        "bigMarioWalkLeft 0", "bigMarioWalkLeft 1"
    };
    protected  static String[] StandLeft =
    {
        "bigMarioStandLeft 0"
    };
    protected  static String[] StandRight =
    {
        "bigMarioStandRight 0"
    };
    protected  static String[] UpRight =
    {
        "bigMarioLookUpRight 0"
    };
    protected  static String[] UpLeft =
    {
        "bigMarioLookUpLeft 0"
    };
    protected  static String[] DuckRight =
    {
        "bigMarioDuckRight 0"
    };
    protected  static String[] DuckLeft =
    {
        "bigMarioDuckLeft 0"
    };

    protected int       duckHeight      = 3;
    protected int       lookupHeight    = 3;

    public BigMario(Mario gameObject)
    {
        super(gameObject);
    }


}
