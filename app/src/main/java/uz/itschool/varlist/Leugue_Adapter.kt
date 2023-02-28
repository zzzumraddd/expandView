package uz.itschool.varlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import uz.itschool.varlist.databinding.ChildItemBinding
import uz.itschool.varlist.databinding.ParentItemBinding

class Leugue_Adapter(
    var leaugues: MutableMap<String, ArrayList<String>>,
    var leaugueTitle: ArrayList<String>
): BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return leaugueTitle.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return leaugues.get(leaugueTitle[p0])!!.size
    }

    override fun getGroup(p0: Int): String {
        return leaugueTitle[p0]
    }

    override fun getChild(p0: Int, p1: Int): String {
       return leaugues.get(leaugueTitle[p0])!!.get((p1))
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
       return false
    }

    override fun getGroupView(position: Int, p1: Boolean, convertView: View?,parent: ViewGroup?): View {
        var binding: ParentItemBinding
        if(convertView == null){
            binding = ParentItemBinding.inflate(LayoutInflater.from(parent!!.context),parent,false)
        }
        else {
            binding = ParentItemBinding.bind(convertView)
        }
        binding.parent.text = leaugueTitle.get(position)
        return binding.root
    }

    override fun getChildView(parentPosition: Int, childPosition: Int, p2: Boolean, convertView: View?, parent: ViewGroup?): View {
        var binding: ChildItemBinding
        if(convertView == null){
            binding = ChildItemBinding.inflate(LayoutInflater.from(parent!!.context),parent,false)
        }
        else {
            binding = ChildItemBinding.bind(convertView)
        }
        binding.child.text = leaugues.get(leaugueTitle[parentPosition])!!.get(childPosition)
        return binding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
       return false
    }
}