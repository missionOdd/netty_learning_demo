// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.mission.netty.eighthExample.proto;

public final class StudentProto {
  private StudentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mission_netty_eighthExample_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mission_netty_eighthExample_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mission_netty_eighthExample_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mission_netty_eighthExample_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mission_netty_eighthExample_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mission_netty_eighthExample_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mission_netty_eighthExample_StudentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mission_netty_eighthExample_StudentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mission_netty_eighthExample_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mission_netty_eighthExample_StudentResponseList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rStudent.proto\022\037com.mission.netty.eight" +
      "hExample\"\035\n\tMyRequest\022\020\n\010username\030\001 \001(\t\"" +
      "\036\n\nMyResponse\022\020\n\010realname\030\002 \001(\t\":\n\017Stude" +
      "ntResponse\022\014\n\004name\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\014\n" +
      "\004city\030\003 \001(\t\"\035\n\016StudentRequest\022\013\n\003age\030\001 \001" +
      "(\005\"`\n\023StudentResponseList\022I\n\017studentResp" +
      "onse\030\001 \003(\01320.com.mission.netty.eighthExa" +
      "mple.StudentResponse2\204\003\n\016StudentService\022" +
      "r\n\025GetRealNameByUsername\022*.com.mission.n" +
      "etty.eighthExample.MyRequest\032+.com.missi" +
      "on.netty.eighthExample.MyResponse\"\000\022x\n\017G" +
      "etStudentByAge\022/.com.mission.netty.eight" +
      "hExample.StudentRequest\0320.com.mission.ne" +
      "tty.eighthExample.StudentResponse\"\0000\001\022\203\001" +
      "\n\026GetStudentWrapperByAge\022/.com.mission.n" +
      "etty.eighthExample.StudentRequest\0324.com." +
      "mission.netty.eighthExample.StudentRespo" +
      "nseList\"\000(\001B7\n%com.mission.netty.eighthE" +
      "xample.protoB\014StudentProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_mission_netty_eighthExample_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_mission_netty_eighthExample_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mission_netty_eighthExample_MyRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_com_mission_netty_eighthExample_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_mission_netty_eighthExample_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mission_netty_eighthExample_MyResponse_descriptor,
        new java.lang.String[] { "Realname", });
    internal_static_com_mission_netty_eighthExample_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_mission_netty_eighthExample_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mission_netty_eighthExample_StudentResponse_descriptor,
        new java.lang.String[] { "Name", "Age", "City", });
    internal_static_com_mission_netty_eighthExample_StudentRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_mission_netty_eighthExample_StudentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mission_netty_eighthExample_StudentRequest_descriptor,
        new java.lang.String[] { "Age", });
    internal_static_com_mission_netty_eighthExample_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_mission_netty_eighthExample_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mission_netty_eighthExample_StudentResponseList_descriptor,
        new java.lang.String[] { "StudentResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
