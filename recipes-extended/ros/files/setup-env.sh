export ROS_ROOT=/opt/ros/ros
export PATH=${ROS_ROOT}/bin:${PATH}
export PYTHONPATH=${ROS_ROOT}/core/roslib/src:$PYTHONPATH
export ROS_PACKAGE_PATH=/opt/ros/stacks
if [ ! "$ROS_MASTER_URI" ] ; then export ROS_MASTER_URI=http://localhost:11311 ; fi

if [ -e ${ROS_ROOT}/tools/rosbash/rosbash ]; then
  . ${ROS_ROOT}/tools/rosbash/rosbash
fi
