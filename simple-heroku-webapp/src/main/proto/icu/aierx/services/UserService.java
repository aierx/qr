// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserService.proto

package icu.aierx.services;

public final class UserService {
  private UserService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_icu_aierx_services_RegisterRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_icu_aierx_services_RegisterRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_icu_aierx_services_RegisterResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_icu_aierx_services_RegisterResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021UserService.proto\022\022icu.aierx.services\"" +
      ";\n\017RegisterRequest\022\014\n\004name\030\001 \001(\t\022\013\n\003tel\030" +
      "\002 \001(\t\022\r\n\005email\030\003 \001(\t\"1\n\020RegisterResponse" +
      "\022\014\n\004code\030\001 \001(\005\022\017\n\007err_msg\030\002 \001(\t2\\\n\003SSR\022U" +
      "\n\010register\022#.icu.aierx.services.Register" +
      "Request\032$.icu.aierx.services.RegisterRes" +
      "ponseB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_icu_aierx_services_RegisterRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_icu_aierx_services_RegisterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_icu_aierx_services_RegisterRequest_descriptor,
        new java.lang.String[] { "Name", "Tel", "Email", });
    internal_static_icu_aierx_services_RegisterResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_icu_aierx_services_RegisterResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_icu_aierx_services_RegisterResponse_descriptor,
        new java.lang.String[] { "Code", "ErrMsg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
