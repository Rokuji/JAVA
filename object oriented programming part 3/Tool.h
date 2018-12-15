#ifndef TOOL_H_INCLUDED
#define TOOL_H_INCLUDED

#include "Item.h"

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
class Tool : public Item{
    private:

    protected:
        double durability;      ///< decreases each time the tool is used
        double speed;           ///< base harvest/mine speed
        std::string material;   ///< material out of which the tool is composed
        std::string modifier;   ///< one of efficiency, fortune, or unbreaking
        int modifer_level;      ///< modifier level in the range 1 to 5

    public:
        /**
         * Default to a tool with an empty name
         */
        Tool();
        ~Tool();

        /**
         * Copy Constructor
         */
        Tool( const Tool &src );
          virtual void display( std::ostream &outs ) const;
   virtual void read( std::istream& ins );
   virtual Item* clone() const;
};

#endif
